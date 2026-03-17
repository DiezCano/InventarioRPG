package app;

import modelos.Item;
import modelos.Personaje;
import modelos.TipoEquipamiento;
import modelos.TipoItem;

import java.util.Map;
import java.util.function.Predicate;

public class main {
    static void main(String[] args) {

        Personaje personaje = new Personaje("Gandalf");
        personaje.agregarItemInventario(
                new Item("Filo del Infinito", "No veas las hostias que doy",
                        10, TipoItem.ARMA));
        personaje.agregarItemInventario(
                new Item("Armadura de sonin", "Esto te protege de los chanclazos de tu madre",
                        7, TipoItem.ARMADURA));
        personaje.agregarItemInventario(
                new Item("Botella de Mana", "Ejem",
                        1, TipoItem.CONSUMIBLE));
        personaje.agregarItemInventario(
                new Item("Botas de rabadon", "Pedazo de botas no veas como corres",
                        3, TipoItem.ARMADURA));

        personaje.agregarEquipo(TipoEquipamiento.MANO_PRINCIPAL, personaje.buscarItem("Vara troncho"));
        personaje.agregarEquipo(TipoEquipamiento.PECHO, personaje.buscarItem("Capa blanca"));

        IO.println("--- EQUIPO ---");
        for(Map.Entry<TipoEquipamiento, Item> entry : personaje.getEquipo()) {
            IO.println(entry.getKey() + ": " + entry.getValue());
        }

        IO.println("--- INVENTARIO ---");
        for(Item item : personaje.getInventario()) {
            IO.println(item);
        }

    }
}
