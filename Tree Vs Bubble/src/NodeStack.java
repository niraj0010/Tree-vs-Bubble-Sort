public class NodeStack {
    public int top;
    public TreeNode[] treeStack = new TreeNode[100];
    public void init() {
        top = -1;
    }
    public void push(TreeNode node) {
        top++;
        treeStack[top] = node;
    }
    public TreeNode pop() {
        TreeNode node = treeStack[top];
        top--;
        return node;
    }
    public boolean isItEmpty() {
        boolean answer = false;
        if (top == -1) {
            answer = true;
        }
        return answer;
    }
}