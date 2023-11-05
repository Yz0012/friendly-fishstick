package yyzz;

public class Linkimpl<T> implements Ilink<T> {
    private Node<T> Head; // 内部类对象
    public Node<T> NodeLink[];// 对象数组
    private int foot = 0; // 操作脚标

    /**
     * @param内部类储存数据
     * @author Y_z00
     */
    private class Node<E> {
        private static Integer count = 0; // 有多少条数据
        public E data; // 数据
        public Node<E> NextNode; // 下一个节点

        public void addNode(Node<E> e) { // 提供数据之间的联系
            if (this.NextNode == null) {// 如果当前节点的下一个对象不存在，则将Node对象传入NextNode中
                this.NextNode = e;
            } else {
                this.NextNode.addNode(e);// 如果已经存在了则调用下一个对象的addNode方法
            }
        }

        public Node(E e) {
            if (this.data == null) { // 如果数据不存在则传入数据
                this.data = e;
            } else { // 如果数据存在则输出"az"
                System.out.println("az");
            }
            return;
        }

        public static Integer getCount() { // 获得数据总量
            return count;
        }

        public Node<E> reNextNode() { // 通过该节点获得下一个节点
            if (NextNode != null) {
                return this.NextNode.reNextNode();
            } else {
                return this.NextNode;
            }
        }

    }

    /**
     * @param增加数据的方法
     */
    @Override
    public void add(T t) {
        if (t == null) { // 判断是否为空
            return;
        } else {
            if (this.Head == null) {
                this.Head = new Node<T>(t); // 如果根为空则传入Node实例
                Node.count++;
                addNodeLink();
            } else {
                this.Head.addNode(new Node<T>(t)); // 如果根不为空则通过调用上一个Node实例获取nextnode构造方法
                Node.count++;
                addNodeLink();
            }
        }
    }

    public Integer getCount() {
        return Node.getCount();
    }

    @Override
    public void addNodeLink() {// 为数据增加索引
        if (this.NodeLink != null && this.Head != null) {
            if (this.Head.NextNode != null) {// 判断根的NextNode是否存在Node对象
                this.NodeLink[foot] = this.Head.reNextNode();
                foot++;
            } else {
                return;
            }
        } else {
            this.NodeLink[foot] = this.Head;// 将第一个数据传入数组
            foot++;
        }
    }

}
