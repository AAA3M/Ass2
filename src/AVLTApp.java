import java.io.IOError;
import java.io.IOException;

public class AVLTApp{
    public static void main(String[] args) throws IOException{
        String path = "/home/alaric/Documents/CSC2/Ass2/DataFiles/";

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