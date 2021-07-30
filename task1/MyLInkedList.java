class MyLinkedList  {
    private Node start;
    private Integer count;

    public MyLinkedList() {
        start = null;
        count = 0;
    }
    private class Node {
        public int value;
        public Node next;

        public Node(int v) {
            value = v;
            next = null;
        }
    }

    public void add(int v) {
        if (start == null) {
            start = new Node(v);
        } else {
            Node tmp = start;
            while(tmp.next != null)
                tmp = tmp.next;
            tmp.next = new Node(v);
        }
        count += 1;
    }

    public void circle(){
        Node tmp = start;
        while(tmp.next != null)
        {
            tmp = tmp.next;
        }
        tmp.next = start;
    }

    public int printResult(int m){
        Node tmp = start;
        int k = tmp.value;
        int num = 1;
        while (true){
            for (int i = 0; i < m - 1 ;i ++)
                tmp = tmp.next;
            if (tmp.value == k)
                return(num);
            num = 10 * num + tmp.value;
        }
    }
}

