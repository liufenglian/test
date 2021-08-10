package tree;

public class NodeTree {
    private String data;
    private NodeTree leftNodeTree;
    private NodeTree rightNodeTree;

    public NodeTree(String data, NodeTree leftNodeTree, NodeTree rightNodeTree) {
        this.data = data;
        this.leftNodeTree = leftNodeTree;
        this.rightNodeTree = rightNodeTree;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public NodeTree getLeftNodeTree() {
        return leftNodeTree;
    }

    public void setLeftNodeTree(NodeTree leftNodeTree) {
        this.leftNodeTree = leftNodeTree;
    }

    public NodeTree getRightNodeTree() {
        return rightNodeTree;
    }

    public void setRightNode() {
        this.rightNodeTree = rightNodeTree;
    }
}
