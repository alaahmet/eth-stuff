public static class STNode {
        int leftIndex;
        int rightIndex;
        int sum = 0;
        int min = Integer.MAX_VALUE ;
        STNode leftNode;
        STNode rightNode;
    }
    static STNode constructSegmentTreeSum(int[] A, int l, int r) {
        if (l == r) {
            STNode node = new STNode();
            node.leftIndex = l;
            node.rightIndex = r;
            node.sum = A[l];
            return node;
        }
        int mid = (l + r) / 2;
        STNode leftNode = constructSegmentTreeSum(A, l, mid);
        STNode rightNode = constructSegmentTreeSum(A, mid+1, r);
        STNode root = new STNode();
        root.leftIndex = leftNode.leftIndex;
        root.rightIndex = rightNode.rightIndex;
        root.sum = leftNode.sum + rightNode.sum;
        root.leftNode = leftNode;
        root.rightNode = rightNode;
        return root;
    }
    static STNode constructSegmentTreeMin(int[] A, int l, int r) {
        if (l == r) {
            STNode node = new STNode();
            node.leftIndex = l;
            node.rightIndex = r;
            node.min = A[l];
            return node;
        }
        int mid = (l + r) / 2;
        STNode leftNode = constructSegmentTreeMin(A, l, mid);
        STNode rightNode = constructSegmentTreeMin(A, mid+1, r);
        STNode root = new STNode();
        root.leftIndex = leftNode.leftIndex;
        root.rightIndex = rightNode.rightIndex;
        root.min = Math.min(leftNode.min,rightNode.min);
        root.leftNode = leftNode;
        root.rightNode = rightNode;
        return root;
    }
    static int getMin(STNode root, int l, int r) {
        if (root.leftIndex >= l && root.rightIndex <= r) {
            return root.min;
        }
        if (root.rightIndex < l || root.leftIndex > r) {
            return Integer.MAX_VALUE;
        }
        return Math.min(getMin(root.leftNode, l, r),getMin(root.rightNode, l, r));
    }
    static int getSum(STNode root, int l, int r) {
        if (root.leftIndex >= l && root.rightIndex <= r) {
            return root.sum;
        }
        if (root.rightIndex < l || root.leftIndex > r) {
            return 0;
        }
        return getSum(root.leftNode, l, r) + getSum(root.rightNode, l, r);
    }