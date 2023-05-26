public class SinglyListDataShow {
    
    public LinkNode head;

        public static class LinkNode{
           public int data;
           public LinkNode next; 

            public LinkNode(int data)
            {
                 this.data = data;
                 this.next = null;
            }
        }
        
        public void display()
        {
            LinkNode current;
            current = head;
            
            while (current != null) {
                
                System.out.print(current.data+ " --> ");
                current = current.next;
            }
            System.out.print("null");

        }

   public static void main(String[] args) {
    
    SinglyListDataShow sim = new SinglyListDataShow();
    sim.head = new LinkNode(10);
    LinkNode first = new LinkNode(20);
    LinkNode second = new LinkNode(30);
    LinkNode third = new LinkNode(40);
    LinkNode forth = new LinkNode(50);

    sim.head.next = first;
    first.next = second;
    second.next = third;
    third.next = forth;
    
    sim.display();


   }

}
