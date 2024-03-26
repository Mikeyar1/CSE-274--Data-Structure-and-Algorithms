package project5;
import java.util.Stack;
/**
* Class: BET
* This class represents a binary expression tree that is initialized with a
postfix string.
* It can convert and print postfix expressions to infix expressions.
*
* @author mikeyarias
* @version 2022-06 (4.24.0)
*/
public class BET {
private BinaryNode root;
private String postfix;
/**
* Default constructor - creates an empty tree.
*/
public BET() {
// creates an empty Tree
root = null;
}
/**
* Constructor accepting postfix string to parse
*
* @param pf - the postfix string
*/
public BET(String pf) {
// builds tree based on input postfix string
this();
if (!pf.isEmpty()) {
buildFromPostfix(pf);
}
}
/**
* Builds the binary expression tree based on the given postfix expression.
*
* @param postfixExpression - the postfix string
* @return true if the tree is built successfully, otherwise false
*/
public boolean buildFromPostfix(String postfixExpression) {
if (postfixExpression == null || postfixExpression.isEmpty()) {
throw new IllegalArgumentException("Invalid postfix expression");
}
String[] tokens = postfixExpression.split("\\s+");
Stack<BinaryNode> stack = new Stack<>();
for (String token : tokens) {
processExpressionToken(token, stack);
}
if (stack.size() != 1) {
throw new IllegalArgumentException("Invalid postfix expression");
}
root = stack.pop(); // The remaining node is the root of the tree
return true;
}
/**
* Processes each token in the postfix expression.
*
* @param token - the current token to process
* @param stack - the stack used for building the tree
*/
private void processExpressionToken(String token, Stack<BinaryNode> stack) {
if (token.matches("[a-zA-Z0-9]+")) {
stack.push(new BinaryNode(token));
} else if (token.matches("[*/+-]")) {
if (stack.size() < 2) {
throw new IllegalArgumentException("Invalid postfix expression:
insufficient operands");
}
buildOperatorNode(token, stack);
} else {
throw new IllegalArgumentException("Invalid token: " + token);
}
}
/**
* Creates a new BinaryNode for the operator and attaches the top two nodes from
the stack as children.
*
* @param operator - the operator token
* @param stack - the stack used for building the tree
*/
private void buildOperatorNode(String operator, Stack<BinaryNode> stack) {
BinaryNode rightChild = stack.pop();
BinaryNode leftChild = stack.pop();
BinaryNode operatorNode = new BinaryNode(operator);
operatorNode.left = leftChild;
operatorNode.right = rightChild;
stack.push(operatorNode);
}
/**
* Method that prints an infix expression from the BET. If tree is empty,
prints
* "No expression available"
*/
public void printInfixExpression() {
if (root == null) {
System.out.println("No expression available");
} else {
printInfixExpression(root);
System.out.println(); // To move to the next line after printing the
expression
}
}
/**
* Recursively prints the infix expression starting from the given node.
*
* @param node - the current node in the tree
*/
private void printInfixExpression(BinaryNode node) {
if (node != null) {
if (node.left != null && node.right != null) {
System.out.print("( ");
}
printInfixExpression(node.left);
System.out.print(node.element + " ");
printInfixExpression(node.right);
if (node.left != null && node.right != null) {
System.out.print(") ");
}
}
}
/**
* Method that prints postfix expression used to build BET. If tree is empty,
* prints "No expression available"
*/
public void printPostfixExpression() {
if (root == null) {
System.out.println("No expression available");
} else {
printPostfixExpression(root);
System.out.println(); // To move to the next line after printing the
expression
}
}
/**
* Recursively prints the postfix expression starting from the given node.
*
* @param node - the current node in the tree
*/
private void printPostfixExpression(BinaryNode node) {
if (node != null) {
printPostfixExpression(node.left);
printPostfixExpression(node.right);
System.out.print(node.element + " ");
}
}
/**
* Outputs number of nodes in the tree
*
* @return int
*/
public int size() {
return size(root); // Call the recursive helper method
}
/**
* Recursively calculates the number of nodes in the tree.
*
* @param node - the current node
* @return the number of nodes
*/
private int size(BinaryNode node) {
if (node == null) {
return 0; // Base case: if the node is null, return 0
} else {
return 1 + size(node.left) + size(node.right); // Count the current node
and then add the count of left and right subtrees
}
}
/**
* isEmpty() - returns true if empty, false if not
*
* @return boolean
*/
public boolean isEmpty() {
return root == null;
}
/**
* BinaryNode class- class representing a node in the BET. Not accessible
* outside this class
*
* @author mikeyarias
*
*/
private class BinaryNode {
String element;
BinaryNode right;
BinaryNode left;
/**
* Constructor to create node with known data
*
* @param String - data to be stored
*/
public BinaryNode(String element) {
this.element = element;
right = null;
left = null;
}
}
}
