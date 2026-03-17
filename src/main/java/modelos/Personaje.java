package modelos;

import lombok.Getter;

import java.util.*;

@Getter
public class Personaje {

    private String nombre;
    private Map<String,Item> inventario;
    private Map<TipoEquipamiento,Item> equipo;

    public Personaje(String nombre) {
        this.nombre = nombre;
        this.inventario = new HashMap<>();
        this.equipo = new TreeMap<>();
    }

    //Con esto agregamos el Item al inventario
    public void agregarItemInventario(Item item) {
        this.inventario.put(item.getNombre(), item);
    }

    //Eliminar del inventario
    public void eliminarItemInventario(String nombreItem) {
        this.inventario.remove(nombreItem);
    }

    //Mostrar todo el inventario
    public List<Item> getInventario() {
        return new ArrayList<>(inventario.values());
    }

    //Buscar Objeto por clave
    public Item buscarItem(String nombreItem){
        return inventario.get(nombreItem);
    }

    public void agregarEquipo(TipoEquipamiento tipoEquipamiento, Item item){
        // Verificar que el item no este en el equipo
        if(equipo.containsKey(tipoEquipamiento)){
            //mover el item al inventario y poner el nuevo
            Item antiguo = equipo.get(tipoEquipamiento);
            inventario.put(antiguo.getNombre(), antiguo);
        }
        //poner el nuevo
        equipo.put(tipoEquipamiento, item);
        //eliminar el nuevo item del inventario
        inventario.remove(tipoEquipamiento,item);

    }

    public void quitarEquipo(TipoEquipamiento tipoEquipamiento){
        Item item = equipo.get(tipoEquipamiento);
        equipo.remove(tipoEquipamiento);
        inventario.put(item.getNombre(),item);
    }

    public List<Map.Entry<TipoEquipamiento, Item>> getEquipo(){
        return new ArrayList<>(equipo.entrySet());
    }

}
