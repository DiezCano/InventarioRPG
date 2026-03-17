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





}
