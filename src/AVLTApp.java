import java.io.IOError;
import java.io.IOException;
import java.nio.file.Paths;

public class AVLTApp{

    static String currentpath = System.getProperty("user.dir");
    static String path = Paths.get(currentpath).getParent().toString() + "/";

    public static void main(String[] args) throws IOException{
        

        if (args.length == 4){
            MyAVLTree x  = new MyAVLTree(path + args[3]);

             x.printAreas(args[0], args[1], args[2]);

        }

        if (args.length ==1){
            MyAVLTree x  = new MyAVLTree(path + args[0]);

            x.printAllAreas();
        }
    }
}