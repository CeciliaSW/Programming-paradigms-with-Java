package com.company;

public class ColaCirc {
    public int frente, fin;
    public Celular[] cel; //Arreglo de objetos adentro de clase.
    Celular cel2 = new Celular(); //Objeto que será llenado en el Main.
    ColaCirc(int tama) {
        this.cel = new Celular[tama];
    }

    public void insertar(Celular cel) {
        if (this.frente == 0 && this.fin == this.cel.length - 1 || this.frente == this.fin + 1) {
            System.out.println("Desbordamiento. La cola está llena. No se puede insertar: " + cel.modelo);
        } else {
            if (this.frente == -1)
                this.frente = 0;
            this.fin = (this.fin + 1) % this.cel.length;
            this.cel[this.fin] = this.cel2; //Se llena el arreglo con su objeto.
            System.out.println("Insertando: " + cel.modelo);
            System.out.println("Frente: " + this.frente + ". Final: " + this.fin + ".");
        }
    }

    public Celular eliminar() {
        Celular temporal = null;
        if (this.frente == -1) {
            System.out.println("Subdesbordamiento. La cola está vacía.");
        } else {
            temporal = this.cel[this.frente];
            if (this.frente == this.fin) {
                this.frente = -1;
                this.fin = -1;
            } //Reinicio de la cola al tener solo un elemento.
            else {
                this.frente = (this.frente + 1) % this.cel.length;
            }
            System.out.println("Eliminando: " + this.cel[this.frente].modelo);
            System.out.println("Frente: " + this.frente + ". Final: " + this.fin + ".");
        }
        return temporal;
    }

    public void imprimirCola() {
        for (int i = this.frente; i != (this.fin + 1); i = (i + 1) % this.cel.length) {
            System.out.print("\n "+(i+1)+": "+this.cel[i].modelo + ", " + this.cel[i].almacenamiento + ", "+this.cel[i].procesador);
            }
        }
    }
 /*
 public String[] nombre;

 ColaCirc(int tama) {
        this.nombre = new String[tama];
        this.frente = -1;
        this.fin = -1;
    }

   */
