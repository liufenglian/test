package tree;

public class BinaryTree {
    //建立一个二叉树节点，从子节点建立起来，再往上建立父节点，因为非叶子节点需要用到下面的节点
    public NodeTree init() {
        NodeTree J = new NodeTree("J", null, null);
        NodeTree I = new NodeTree("I", null, null);
        NodeTree H = new NodeTree("H", null, null);
        NodeTree G = new NodeTree("G", null, null);
        NodeTree F = new NodeTree("F", I, J);
        NodeTree E = new NodeTree("E", H, null);
        NodeTree D = new NodeTree("D", null, G);
        NodeTree C = new NodeTree("C", F, null);
        NodeTree B = new NodeTree("B", D, E);
        NodeTree A = new NodeTree("A", B, C);
        //返回根节点
        return A;
    }

    //先序遍历，先查找父节点，然后是左节点，最后是右节点
    public void preTraversal(NodeTree nodeTree) {
        System.out.print(nodeTree.getData());
        if (nodeTree.getLeftNodeTree() != null) {
            System.out.print("->");
            preTraversal(nodeTree.getLeftNodeTree());
        }

        if (nodeTree.getRightNodeTree() != null) {
            System.out.print("->");
            preTraversal(nodeTree.getRightNodeTree());
        }
    }

    //中序遍历，先查找左节点，然后是父节点，最后是右节点
    public void inTraversal(NodeTree nodeTree) {
        if (nodeTree.getLeftNodeTree() != null) {
            inTraversal(nodeTree.getLeftNodeTree());
            System.out.print("->");
        }
        System.out.print(nodeTree.getData());
        if (nodeTree.getRightNodeTree() != null) {
            System.out.print("->");
            inTraversal(nodeTree.getRightNodeTree());
        }
    }

    //后序遍历，先查找左子树，然后是右节点，最后是父节点
    public void postTraversal(NodeTree nodeTree) {
        if (nodeTree.getLeftNodeTree() != null) {
            postTraversal(nodeTree.getLeftNodeTree());
            System.out.print("->");
        }

        if(nodeTree.getRightNodeTree() != null) {
            postTraversal(nodeTree.getRightNodeTree());
            System.out.print("->");
        }

        System.out.print(nodeTree.getData());
    }

    /*
     * 1.如果一个树只有根节点，那么返回树深度是1
     * 2.如果根节点只有左节点而没有右节点，那么返回树的深度是左子树的深度+1
     * 3.如果根节点只有右节点而没有左节点，那么返回树的深度是右子树的深度+1
     * 4.如果根节点既有左节点，又有右节点，那么返回树的深度是左、右子树的较大值+1
     */
    public int getTreeDepth(NodeTree nodeTree) {

        if (nodeTree.getLeftNodeTree() == null && nodeTree.getRightNodeTree() == null) {
            return 1;
        }

        int leftDepth = 0, rightDepth = 0;
        if (nodeTree.getLeftNodeTree() != null) {
            leftDepth = getTreeDepth(nodeTree.getLeftNodeTree());
        }

        if (nodeTree.getRightNodeTree() != null) {
            rightDepth = getTreeDepth(nodeTree.getRightNodeTree());
        }

        return leftDepth > rightDepth ? leftDepth+1: rightDepth+1;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        NodeTree nodeTree = tree.init();

        System.out.print("先序遍历：");
        tree.preTraversal(nodeTree);

        System.out.println();
        System.out.print("中序遍历：");
        tree.inTraversal(nodeTree);

        System.out.println();
        System.out.print("后序遍历：");
        tree.postTraversal(nodeTree);

        System.out.println();
        System.out.print("树的高度为：");
        System.out.println(tree.getTreeDepth(nodeTree));
    }
}
