import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
/**
 * App which excecutes the printAreas and printAllAreas methods of the LSData object using a Binary Search Tree.
 * It follows user arguments to determine the textfile and the key
 * 
 * @author Alaric McGregor
 */
public class LSBSTApp{

    static String currentpath = System.getProperty("user.dir");
    static String path = Paths.get(currentpath).getParent().toString() + "/";
    /**
     * main method which will run methods from the MyBinTree class depending on arguments from the user.
     * The argument is either the name of the file, which should be located in the Ass2 file. Or the 3 arguments form the LS data plus the name of the file.
     * 
     * @param args list of String arguments including a name of the file.
     * @throws FileNotFoundException throws an exception if there is no file.
     */
    public static void main(String args[])throws IOException, FileNotFoundException
    {
        

        if (args.length == 4){
            MyBinTree x  = new MyBinTree(path + args[3]);

             x.printAreas(args[0], args[1], args[2]);

        }

        if (args.length ==1){
            MyBinTree x  = new MyBinTree(path + args[0]);

            x.printAllAreas();
        }
    }
}