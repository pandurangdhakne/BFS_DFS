
public class SimpleSIngliyListaddFirst {

    public LinkNode head;

       public static class LinkNode{ // create a node

        public int data;
        public LinkNode next;

        public LinkNode(int data)
        {
            this.data = data;
            this.next = null;
        }

       }

       public void display() // display node
       {
           LinkNode current;
           current = head;

           while(current != null)
           {
               System.err.print(current.data+" --> ");
               current = current.next;
           }
           System.out.print("null");
       }  

       public void addFirst() // add first 

       {
           LinkNode addfirst = new LinkNode(100);
           addfirst.next = head;
           head = addfirst;

       }

       public void addEnd() // add end
       {
           LinkNode addend = new LinkNode(200);

           if(head == null)
           {
               head = addend;
               return;
           }

           LinkNode current = head;
           while (current.next != null) {
            
                 current = current.next;
           }
           current.next = addend;

       }
     

    public static void main(String[] args) {
    
       SimpleSIngliyListaddFirst sim = new SimpleSIngliyListaddFirst();
       sim.head = new LinkNode(10);
       LinkNode first = new LinkNode(20);
       LinkNode second = new LinkNode(30);
       LinkNode third = new LinkNode(40);
       LinkNode forth = new LinkNode(50);

       sim.head.next = first;
       first.next = second;
       second.next = third;
       third.next = forth;
 
       sim.display(); // display
       System.err.println();
       sim.addFirst(); // add first
       System.err.println();
       sim.display();  // display
       System.err.println();
       sim.addEnd(); // add end
       System.err.println();
       sim.display(); // display
       

        
    }
    
}