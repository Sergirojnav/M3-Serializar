package serializacion.nativa;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import static java.lang.System.in;
import serializacion.Product;

public class deserializar {

    public static void main(String[] args) { 
             
        Product prod = null;
        try {
            FileInputStream fileIn = new FileInputStream(".\\Product.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            prod = (Product) in.readObject();
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
        System.out.println("ID: " + prod.id);
        System.out.println("Name: " + prod.name);
        System.out.println("Price: " + prod.price);
        
    }
}

