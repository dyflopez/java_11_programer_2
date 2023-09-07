package Facade;

public class PrincipalFacate {

    /**
     * Patrones Creaciones : Son patrondes de diseño qie nos solucionan nuestro problema de la creacion
     *  Factory
     *  AbtractMtrhod
     *  Builder
     *  Prototype
     *  Singleton *
     * Patron de comportamiento : Son los patrones qque se encargan de definir la forma en que interactuan y
     *  se rearten responsabilidad
     *
     *  Chain of responsability
     *  command
     *  Interpreter
     *  Mediator
     *  Memento *
     *  Observe * WebFlux y programacion reactiva
     *  Stare . Eventos
     *   Strategy
     *   Template Mehtot
     *  Visitor
     *
     *  Patrones Estructurales : son patrones de diseño que tratan la coposicion de las clases o objetos
     *
     *  Adaptar
     *  Bridge
     *  Decorator
     *  Coposite
     *  Facede
     *  flywegth
     *  Proxy
     */
    public static void main(String[] args) {
        CreditMarket creditMarket = new CreditMarket();

        creditMarket.showCreditBlack();
    }
}
