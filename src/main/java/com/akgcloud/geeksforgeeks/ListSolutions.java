package com.akgcloud.geeksforgeeks;

public class ListSolutions {
    private Node head = null;

    // List1 = 1->3->30->90->120->240->511
    // List2 =0->3->12->32->90->125->240->249
    // output : list =1->3->12->32->90->125->240->511
    public static void getMaximumSumList(Node list1, Node list2) {
        Node result = null;
        Node cur1 = list1, cur2 = list2;
        Node pre1 = list1, pre2 = list2;
        while (cur1 != null || cur2 != null) {
            int sum1 = 0, sum2 = 0;

            while (cur1 != null && cur2 != null && cur1.data != cur2.data) {
                if (cur1.data > cur2.data) {
                    sum2 = sum2 + cur2.data;
                    cur2 = cur2.next;
                } else {
                    sum1 = sum1 + cur1.data;
                    cur1 = cur1.next;
                }
            }

            if (cur1 == null) {
                while (cur2 != null) {
                    sum2 = sum2 + cur2.data;
                    cur2 = cur2.next;
                }
            }

            if (cur2 == null) {
                while (cur1 != null) {
                    sum1 = sum1 + cur1.data;
                    cur1 = cur1.next;
                }
            }

            if (pre1 == list1 && pre2 == list2) {
                result = (sum1 > sum2) ? pre1 : pre2;
            } else {
                if (sum1 > sum2) {
                    pre2.next = pre1.next;
                } else {
                    pre1.next = pre2.next;
                }
            }

            pre1 = cur1;
            pre2 = cur2;

            if (cur1 != null)
                cur1 = cur1.next;
            if (cur2 != null)
                cur2 = cur2.next;
        }
        System.out.println("Result : ");
        while (result != null) {
            System.out.print(result.data + "->");
            result = result.next;
        }
    }

    // Input List: 1->2->3->4->5->6
    // Output List: 1->3->5->6->4->2
    public void reverseAltAppendEnd() {
        Node list = head;
        Node odd = head;
        int i = 1;
        while (list != null) {
            if (i % 2 == 0) {
                
            } else {
                odd.next = list.next;
            }
            odd = list;
            list = list.next;
            i++;
        }
    }

    public void add(int n) {
        Node list = head;
        Node newNode = new Node(n);

        if (list == null) {
            list = head = new Node(n);
        } else {
            while (list.next != null) {
                list = list.next;
            }
            list.next = newNode;
        }
    }

    public void deleteNode(int delete) {
        Node list = head;
        Node old = head;
        if (list == null) {
            return;
        } else if (list != null && list.data == delete) {
            head = head.next;
        } else {
            while (list != null) {
                if (list.data == delete) {
                    old.next = list.next;
                    break;
                }
                old = list;
                list = list.next;
            }
        }
    }

    public void deletePosition(int pos) {
        Node list = head;
        int i = 0;
        if (pos < 0 || list == null || pos >= size()) {
            return;
        } else if (pos == 0) {
            head = head.next;
        } else {
            while (list != null && list.next != null) {
                if (i == pos - 1) {
                    list.next = list.next.next;
                    break;
                }
                list = list.next;
                i++;
            }
        }
    }

    public void reverseDisplay() {
        if (head == null) {
            return;
        }
        if (head.next == null) {
            System.out.println(head.data);
        } else {
            head = head.next;
            reverseDisplay();
        }
    }

    public int size() {
        Node list = head;
        int i = 0;
        while (list != null) {
            list = list.next;
            i++;
        }
        return i;
    }

    public void display() {
        Node list = head;
        if (list == null) {
            return;
        } else {
            while (list != null) {
                System.out.print(list.data + "->");
                list = list.next;
            }
            System.out.println("null");
        }
    }

    public static void main(String[] args) {
        ListSolutions list1 = new ListSolutions();
        list1.add(1);
        list1.add(3);
        list1.add(30);
        list1.add(90);
        list1.add(120);
        list1.add(240);
        list1.add(511);
        System.out.print("list1 : ");
        list1.display();
        list1.deleteNode(511);
        System.out.print("list after delete : ");
        list1.display();
        ListSolutions list3 = new ListSolutions();
        System.out.print("list3 size : " + list3.size());

        ListSolutions list2 = new ListSolutions();
        list2.add(0);
        list2.add(3);
        list2.add(12);
        list2.add(32);
        list2.add(90);
        list2.add(125);
        list2.add(240);
        list2.add(249);
        System.out.println("");
        System.out.print("list2 : ");
        list2.display();

        System.out.println("");
        // ListSolutions.getMaximumSumList(list1.head, list2.head);

    }

    private class Node {
        public int  data;
        public Node next;

        public Node(int x) {
            data = x;
            next = null;
        }
    }

}
