#sciprt to text BST vs LS from java code

import subprocess
import os


def executeAVL(DataFile):
    path = "/home/alaric/Documents/CSC2/Ass2/DataFiles/"
    NewFile = DataFile[:-4]
    file = open(path + DataFile, "r")
    filew = open("/home/alaric/Documents/CSC2/Ass2/DataFiles/FinalData/"+ NewFile + "_AVL_Data.txt", "w")


    while True:
        line = file.readline().strip()
        if line == '':
            file.close()
            # either end of file or just a blank line.....
            # we'll assume EOF, because we don't have a choice with the while loop!
            break
        else:
            arr = line.split(' ', 1)
            key = arr[0] 
            arr = (key.split('_', 2))

            s = subprocess.check_output("""java AVLTApp """ + arr[0] + ' ' + arr[1] + ' ' + arr[2] + ' ' +DataFile, shell= True)
            x = (s.decode("utf-8")) #places the output of the java LSArrayApp into a string called x
            y = x.split('\n', 5) # split based on the lines output from the java file
            x = (y[5])[:-1] + ',' +(y[3]) + '\n' # make x a String that has the Number of Search Comparisons[line 6], Number of Insert Comparisons

            filew.write(x)
    filew.close()


def executeBST(DataFile):
    #store the output of the java prgram
    #LengthOfFile = len(open(DataFile).readlines())
    NewFile = DataFile[:-4]

    path = "/home/alaric/Documents/CSC2/Ass2/DataFiles/"
    file = open(path + DataFile, "r")
    filew = open("/home/alaric/Documents/CSC2/Ass2/DataFiles/FinalData/" + NewFile + "testtest.txt", "w")
    while True:
        line = file.readline().strip()
        if line == '':
            file.close()
            # either end of file or just a blank line.....
            # we'll assume EOF, because we don't have a choice with the while loop!
            break
        else:
            arr = line.split(' ', 1)
            key = arr[0] 
            arr = (key.split('_', 2))

            s = subprocess.check_output("""java LSBSTApp """ + arr[0] + ' ' + arr[1] + ' ' + arr[2] + ' ' +DataFile, shell= True)
            x = (s.decode("utf-8"))
            y = x.split('\n', 5)
            x = y[4] +',' + y[2] +'\n'

            filew.write(x)
    filew.close()


def executeBTree(DataFile):
    #store the output of the java prgram
    #LengthOfFile = len(open(DataFile).readlines())
    NewFile = DataFile[:-4]

    path = "/home/alaric/Documents/CSC2/Ass2/DataFiles/"
    file = open(path + DataFile, "r")
    filew = open("/home/alaric/Documents/CSC2/Ass2/DataFiles/FinalData/" + NewFile + "_BTree_Data.txt", "w")
    while True:
        line = file.readline().strip()
        if line =='':
            file.close()
            break
        else:
            arr = line.split(' ', 1)
            key = arr[0]
            arr = (key.split('_', 2))

            s = subprocess.check_output("""java BTreeApp """ + arr[0] + ' ' + arr[1] + ' ' + arr[2] + ' ' +DataFile, shell= True)
            x = (s.decode("utf-8"))

            y = x.split('\n', 5)
            x = y[4] +',' + y[2] +'\n'
            filew.write(x)
    filew.close()
            

"""
for i in range(2,11):
    if __name__=="__main__":
        executeAVL("SubSet" + str(i) + ".txt")
"""
for i in range(1):

    if __name__=="__main__":
        executeBST("SubSet1" + ".txt")
"""

    if __name__=="__main__":
        executeBST("SubSet" + str(i) + ".txt")

"""