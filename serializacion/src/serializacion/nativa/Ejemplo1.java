package serializacion.nativa;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import static java.lang.System.in;
import serializacion.Product;

public class Ejemplo1 {

    public static void main(String[] args) {
        Product prod = new Product(1, "iPhone", 300.75);
        System.out.println(prod.toString());
        System.out.println("Vamos a serializar el producto");
        serializar(prod);
        
    }

    static void serializar(Product p) {
        FileOutputStream fileOut = null;
        try {
            fileOut = new FileOutputStream(".\\Product.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(p);
            System.out.println("Serialized data is saved in /Product.ser");
        } catch (FileNotFoundException ex) {
            System.out.println("No se encuantra la ruta del fichero" + ex.getMessage());
        } catch (IOException ex){
            System.out.println("error"+ex.getMessage());
        } finally {
            try{
                fileOut.close();
            } catch (IOException ex){
                System.out.println("Error fichero"+ex.getMessage());
            }
            
            
              try {
            FileInputStream fileIn = new FileInputStream(".\\Product.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            p = (Product) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Product class not found");
            c.printStackTrace();
            return;
        }
        
        System.out.println("Deserialized product....");
        System.out.println("ID: " + p.id);
        System.out.println("Name: " + p.name);
        System.out.println("Price: " + p.price);
        
    }
            
        }
        
    }
    

        
