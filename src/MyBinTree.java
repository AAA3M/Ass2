import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;

/**
 * A Class which creates a MyBinTree object which will store data from a text file in a binary search tree.
 * The Tree will load in LSData Objects as arguments and will perform methods to search for Datapoints
 * 
 * @author Alaric McGregor
 */

public class MyBinTree{
    private String outputString;
    private File file;
    private int fileLength;
    private BinarySearchTree<LSData> bt;

    /**
     * Constructor which will create the MyBinTree object which will load in data from a text file.
     * 
     * @param FileName Name of the File from which data is loaded. eg. "Data.txt"
     * @throws IOException throws an exception if the File is not found.
     */

    public MyBinTree(String FileName) throws IOException{

        this.file = new File(FileName);
        this.fileLength = fileLen(); 
        Scanner sc = new Scanner(file);
        this.bt = new BinarySearchTree<LSData> ();
        


        for (int i=0; i< fileLength; i ++){

            bt.insert(new LSData(sc.nextLine()));
        }
        sc.close();
    }

    /**
     * Method to find the length of the file which the MyBinTree is using
     * 
     * @return an int which is the length of the file 
     * @throws IOException throws an exception if there is no file or the buffered reader doesn't work
     */

    private int fileLen() throws IOException{
        int fileLeng = 0;

        BufferedReader br = new BufferedReader(new FileReader(this.file));
        while (br.readLine() != null) {
            fileLeng ++;
        }
        br.close();
        return fileLeng;
    }

    /**
     * traverses through the Binary search Tree and prints all the Data Nodes in left to right order.
     */

    public void printAllAreas(){
        outputString = "";
        bt.inOrder();
        System.out.print("\033[H\033[2J");
        outputString = bt.getOutputData();

    }
    /**
     * takes an argument which forms a key and finds an object in the Binary Search Tree with that same key.
     * It will then print out the number of comparisons used to find and insert aswell as if the zone was found 
     * and what zone was found.
     * 
     * @param stage This forms part of the key and is the Stage of the load shedding
     * @param day This forms part of the key and is the day of the load shedding
     * @param startTime This forms part of the key and is the starting time of the load shedding
     */

    public void printAreas(String stage, String day, String startTime){
        String check = new String (stage + "_"+day+"_"+startTime + " NA");
        outputString = "";

            BinaryTreeNode<LSData> x = (bt.find(new LSData(check)));
            if (x==null){
                //System.out.println("No zones found for:");
                outputString +=("No zones found for:\n");
                //System.out.println(stage + "_"+day+"_"+startTime);
                outputString+=(stage + "_"+day+"_"+startTime) + "\n";
                //System.out.println();
                //System.out.println("Number of comparisons to insert:\n"+  bt.DiscreteCounterInsert);
                outputString +=("Number of comparisons to insert:\n"+ bt.DiscreteCounterInsert +"\n");
                //System.out.println("Number of comparisons to find:\n" + bt.DiscreteCounter);
                outputString+=("Number of comparisons to find:\n" +bt.DiscreteCounter);
            }
            if (x != null){
                //System.out.println("Zone(s) found for:");
                outputString+=("Zone(s) found for:\n");
                //System.out.println((x.data).toString());
                outputString+=((x.data).toString()) +"\n";
                //System.out.println("Number of comparisons to insert:");
                outputString+=("Number of comparisons to insert:\n");
                //System.out.println(bt.DiscreteCounterInsert);
                outputString+=(bt.DiscreteCounterInsert) + "\n";
                //System.out.println("Number of comparisons to find:");
                outputString+=("Number of comparisons to find:\n");
                //System.out.println(bt.DiscreteCounter);
                outputString+=(bt.DiscreteCounter);
            
            }
            //else
                //System.out.println("Invalid Arguments");
            
    
    
    
    }     
     /**Gets the String from the printAreas or PrintAllAreas and returns it 
    * 
    * @return String representation of the output from the PrintAllAreas or PrintAreas method.
    */
    public String getOutPutString(){
        return this.outputString;
    }


}