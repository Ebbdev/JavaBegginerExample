public class CircularQueue {
	 private int rear , front;
	    private Object[] elements;

	    public CircularQueue(int capacity) {
	        elements = new Object[capacity];
	        rear = -1;
	        front = 0;
	    }
	    
	    void Enqueue(Object  data)
		 {
	             if(isFull()){
	                 System.out.println("Queue overflow");
	             }
	             else{
	                 rear = (rear+1)% elements.length;
	                 elements[rear] = data;
	             }  
		 }
	    
	    Object dequeue() 
	      {
	          if(isEmpty()){
	              System.out.println("Queue is empty");
	              return null;
	          }
	          else{
	              Object retData = elements[front];
	              elements[front] = null;
	              front = ((front+1) % elements.length);
	              return retData;
	          }
		   }
	    
	    Object  Peek()
	    {
	       if(isEmpty()){
	           System.out.println("Queue is empty");
	           return null;
	       }
	       else{
	    	   Object data = elements[front];
	           return data;
	       }
	    }
	    
	    boolean isEmpty(){
	        if(elements[front]==null){
	            return true;
	        }
	        else{
	            return false;
	        }
	    }
	    
	    boolean isFull(){
	        if(front == (rear+1) % elements.length && elements[front] != null && elements[rear] != null){
	            return true;
	        }
	        else{
	        	return false;
	        }
	    }
	    
	    /// Size fonksyonum normalde rear ve front �eklindeydi fakat uygulama esnas�nda sorun
	    /// ��kard��� i�in bu �ekilde s�f�rdan yazd�m. Daha sonradan d�zelttim hatay� onu da yorum olarak buraya ekliyorum.
	    
	    /* Ilk kulland���m size 
	     * 
	     * public int size(){
	     * 			if(rear>=front){ return rear-front+1;}
	     * 			
	     * 			else if(elements[front] != null){return elements.lenght-(front-rear)+1;}
	     * 			
	     * 			else{return 0; }
	     * }
	     * 
	     */
	    
	    ///�uan ikisi de �al��maktad�r ama bu daha ho�uma gitti�inden bunu kulland�m.
	    int size(){
	    	int size = 0;
	       for (int i = 0; i < elements.length; i++) {
	    	   if(elements[i] != null) {
				size++;
	    	   }
	       }
	       return size;
	    }
	    
	   
	    
	    /// @author Emirhan Bilge Bulut////
	    /// kolay bir �ekilde g�nderilen objenin ka� tane oldu�unu buldurdu�um fonksyon
	    /// A�a��daki fonksiyonu 4 veya daha �st� var m� diye do�rudan �a��rarak kontrol ettiriyorum.
	    public Object ebb_counter_object(Object input){
	    	int counter = 0 ;
	            for (int i = 0; i <elements.length; i++) {
	                if(elements[i] == input){
	                    counter++;
	                }
	            }
	            return counter;
	        }
	    
	    
	    /// @author Emirhan Bilge Bulut ///
	    /// a�a��daki fonksiyonu ise 1-2-3-4-5-6 sa�land� m� kontrol etmek amac� ile yazd�m.
	    /// 
	        public int search(int input){
	        	for (int i = 0; i < size(); i++) {
	        		try {
	        			if(input == (int) elements[i] && elements[i] != null){
		                    return (int) 1;
		                }
	        		}
	        		catch (Exception e){	
	            	}
	            }
	            return (int) -1;
	        }
	        
	        
	        ////Display fonksiyonunu burada tan�mlamak istedim ama CLASS BACKGROUND'da da ayn�s�n� yapabilirdim buradakinin kendi queue class'�ma �zel 
	        /// ve her zaman kullan�labilir olmas�n� istedim. 
	        void display() {
	        	for (int i = 0; i < elements.length; i++) {
	        		if(elements[i] != null) {
	        			System.out.print(" " + elements[i] + " ");
	        		}
	        	}
	        }
}
