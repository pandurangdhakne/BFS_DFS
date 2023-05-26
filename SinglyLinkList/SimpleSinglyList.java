import java.util.List;

public class SimpleSinglyList {

     public  ListNode head;

    public static class ListNode{
     
        public int data;
        public ListNode next;

        public ListNode(int data) // create node
        {
            this.data = data;
            this.next = null;

            // System.out.println(this.data);
        }

        

    }


    public static void main(String[] args) {

        SimpleSinglyList sim = new SimpleSinglyList();
        sim.head = new ListNode(10); // 10

        ListNode second = new ListNode(20);
        ListNode third = new ListNode(30);
        ListNode forth = new ListNode(40);

        sim.head.next = second;
        second.next = third;
        third.next = forth;
    
        
         
       

    }

}