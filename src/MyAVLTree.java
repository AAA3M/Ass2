import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;

public class MyAVLTree {

    private File file;
    private int fileLength;
    private AVLTree<LSData> at;

    public MyAVLTree(String FileName) throws IOException{

        this.file = new File(FileName);
        this.fileLength = fileLen(); 
        Scanner sc = new Scanner(file);
        this.at = new AVLTree<LSData> ();
        


        for (int i=0; i< fileLength; i ++){

            at.insert(new LSData(sc.nextLine()));
        }
        sc.close();
    }

    private int fileLen() throws IOException{
        int fileLeng = 0;

        BufferedReader br = new BufferedReader(new FileReader(this.file));
        while (br.readLine() != null) {
            fileLeng ++;
        }
        br.close();
        return fileLeng;
    }

    public void printAllAreas(){
        at.treeOrder();
    }

    public void printAreas(String stage, String day, String startTime){
        String check = new String (stage + "_"+day+"_"+startTime + " NA");


            BinaryTreeNode<LSData> x = (at.find(new LSData(check)));
            if (x==null){
                System.out.println("No zones found for:");
                System.out.println(stage + "_"+day+"_"+startTime);
                System.out.println();
                System.out.println("Number of comparisons to insert:"+ at.DiscreteCounterInsert);
                System.out.println("Number of comparisons to find:" + at.DiscreteCounterFind);
            }
            if (x != null){
                System.out.println("Zone(s) found for:");
                System.out.println((x.data).toString());
                System.out.println("Number of comparisons to insert:");
                System.out.println(at.DiscreteCounterInsert);
                System.out.println("Number of comparisons to find:");
                System.out.println(at.DiscreteCounterFind);
            }
        
            else
            {
                System.out.println("Invalid Arguments");
            }
    
    
    }  

}
