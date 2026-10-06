class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}

public class App {
    private Node createQuadTree(int[][] grid, int startRow, int endRow, int startColumn, int endColumn) {
        Node currentNode = new Node();
        currentNode.val = grid[startRow][startColumn] == 0 ? false : true;
        for (int row = startRow; row < endRow; row++)
            for (int column = startColumn; column < endColumn; column++)
            if ((currentNode.val == true && grid[row][column] == 0) || (currentNode.val == false && grid[row][column] == 1)) {
                currentNode.topLeft = createQuadTree(grid, startRow, (startRow + endRow) / 2, startColumn, (startColumn + endColumn) / 2);
                currentNode.topRight = createQuadTree(grid, startRow, (startRow + endRow) / 2, (startColumn + endColumn) / 2, endColumn);
                currentNode.bottomLeft = createQuadTree(grid, (startRow + endRow) / 2, endRow, startColumn, (startColumn + endColumn) / 2);
                currentNode.bottomRight = createQuadTree(grid, (startRow + endRow) / 2, endRow, (startColumn + endColumn) / 2, endColumn);
                currentNode.isLeaf = false;
                currentNode.val = true;
                return currentNode;
            }
        currentNode.isLeaf = true;
        return currentNode;
    }

    public Node construct(int[][] grid) {
        return createQuadTree(grid, 0, grid.length, 0, grid.length);
    }

    public static void main(String[] args) throws Exception {
        testConstruct(
                new int[][] {{0, 1}, {1, 0}},
                java.util.Arrays.asList("[0,1]", "[1,0]", "[1,1]", "[1,1]", "[1,0]"));
        testConstruct(
                new int[][] {
                    {1, 1, 1, 1, 0, 0, 0, 0},
                    {1, 1, 1, 1, 0, 0, 0, 0},
                    {1, 1, 1, 1, 1, 1, 1, 1},
                    {1, 1, 1, 1, 1, 1, 1, 1},
                    {1, 1, 1, 1, 0, 0, 0, 0},
                    {1, 1, 1, 1, 0, 0, 0, 0},
                    {1, 1, 1, 1, 0, 0, 0, 0},
                    {1, 1, 1, 1, 0, 0, 0, 0}
                },
                java.util.Arrays.asList(
                        "[0,1]", "[1,1]", "[0,1]", "[1,1]", "[1,0]",
                        null, null, null, null, "[1,0]", "[1,0]", "[1,1]", "[1,1]"));
            testConstruct(
                new int[][] {
                    {1, 1, 0, 0},
                    {0, 0, 1, 1},
                    {1, 1, 0, 0},
                    {0, 0, 1, 1}
                },
                java.util.Arrays.asList(
                    "[0,1]", "[0,1]", "[0,1]", "[0,1]", "[0,1]",
                    "[1,1]", "[1,1]", "[1,0]", "[1,0]", "[1,0]", "[1,0]",
                    "[1,1]", "[1,1]", "[1,1]", "[1,1]", "[1,0]", "[1,0]",
                    "[1,0]", "[1,0]", "[1,1]", "[1,1]"));
    }

    private static void testConstruct(int[][] grid, java.util.List<String> expected) {
        java.util.List<String> actual = serialize(new App().construct(grid));
        if (!actual.equals(expected))
            throw new AssertionError("Expected " + expected + " but got " + actual);
        System.out.println("Passed: " + actual);
    }

    private static java.util.List<String> serialize(Node root) {
        java.util.List<String> result = new java.util.ArrayList<>();
        java.util.Queue<Node> nodes = new java.util.LinkedList<>();
        nodes.add(root);

        while (!nodes.isEmpty()) {
            Node node = nodes.remove();
            if (node == null) {
                result.add(null);
                continue;
            }

            result.add("[" + (node.isLeaf ? 1 : 0) + "," + (node.val ? 1 : 0) + "]");
            nodes.add(node.topLeft);
            nodes.add(node.topRight);
            nodes.add(node.bottomLeft);
            nodes.add(node.bottomRight);
        }

        while (!result.isEmpty() && result.get(result.size() - 1) == null)
            result.remove(result.size() - 1);
        return result;
    }
}
