package com.infra.demo.cor;


import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

class Event<Args>{
    private int index= 0;
    private Map<Integer, Consumer<Args>>
            handlers = new HashMap<>();

    public int subscribe(Consumer<Args> handler){
        int i = index;
        handlers.put(index++,handler);
        return i;
    }

    public void unsubscribe(int key){
        handlers.remove(key);
    }

    public void fire(Args args){
        for (Consumer<Args> handler : handlers.values()){
            handler.accept(args);
        }
    }
}
class Query{
    protected String creatureName;
    enum Argument {
        ATTACK,DEFENSE;
    }
    public Argument argument;

    public  int result; // result is the value of that the handler can actually modify.

    public Query(String creatureName, Argument argument, int result) {
        this.creatureName = creatureName;
        this.argument = argument;
        this.result = result;
    }
}

//mediator
class Game{
    public Event<Query> queries = new Event<>();
}

class Creature{
    private Game game;
    public String name;
    public int baseAttack,baseDefense;

    public Creature(Game game, String name, int baseAttack, int baseDefense) {
        this.game = game;
        this.name = name;
        this.baseAttack = baseAttack;
        this.baseDefense = baseDefense;
    }

    int getAttack(){
        Query q = new Query(name, Query.Argument.ATTACK, baseAttack);
        game.queries.fire(q);
        return q.result;
    }

    int getDefense(){
        Query q = new Query(name, Query.Argument.DEFENSE, baseDefense);
        game.queries.fire(q);
        return q.result;
    }

    @Override
    public String toString() {
        return "Creature{" +
                "game=" + game +
                ", name='" + name + '\'' +
                ", Attack=" + getAttack() +
                ", Defense=" + getDefense() +
                '}';
    }
}

class CreatureModifier{
    protected Game game;
    protected Creature creature;

    public CreatureModifier(Game game, Creature creature) {
        this.game = game;
        this.creature = creature;
    }
}

class DoubleAttackModifier extends CreatureModifier implements AutoCloseable{
    private final int token;

    public DoubleAttackModifier(Game game, Creature creature) {
        super(game, creature);
        token=game.queries.subscribe(q -> {
            if(q.creatureName.equals(creature.name)
                    && q.argument.equals(Query.Argument.ATTACK) ){
                q.result *= 2;
            }
        });
    }

    @Override
    public void close() {
        game.queries.unsubscribe(token);
    }
}

class IncreasedDefenseModifier extends CreatureModifier{

    public IncreasedDefenseModifier(Game game, Creature creature) {
        super(game, creature);
        game.queries.subscribe(q -> {
            if(q.creatureName.equals(creature.name)
                    && q.argument.equals(Query.Argument.DEFENSE) ){
                q.result += 3;
            }
        });
    }
}


class ChainOfResponsibilityWithObserver {
    public static void main(String[] args) {
        Game game = new Game();;
        Creature rancho = new Creature(game, "rancho", 2, 2);

        System.out.println(rancho);

        IncreasedDefenseModifier idm = new IncreasedDefenseModifier(game, rancho);
        try(DoubleAttackModifier dam = new DoubleAttackModifier(game,rancho);) {
            System.out.println(rancho);
        }

        System.out.println(rancho);
        System.out.println(rancho);

    }
}