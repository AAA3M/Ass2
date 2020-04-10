JAVAC=/usr/bin/javac
.SUFFIXES: .java .class
SRCDIR=src
BINDIR=bin
JAVADOCDIR=doc

$(BINDIR)/%.class:$(SRCDIR)/%.java
	$(JAVAC) -d $(BINDIR)/ -cp $(BINDIR) $<

CLASSES=BinaryTreeNode.class BTQueueNode.class BTQueue.class \
		BinaryTree.class \
        BinarySearchTree.class LSData.class MyBinTree.class \
		LSBSTApp.class\
		AVLTree.class AVLTreeTest.class MyAVLTree.class \
		AVLTApp.class BTree.class LSBTree.class BTreeApp.class

CLASS_FILES=$(CLASSES:%.class=$(BINDIR)/%.class)
default: $(CLASS_FILES)
clean:
	rm $(BINDIR)/*.class
runBST:
	java -cp bin LSBSTApp

runAVL:
	java -cp bin AVLTApp
