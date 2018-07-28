
public class Resolve {

	public int b[][]=new int[9][9];
	public boolean isResolved;
	public long t1,t2;
	public TimeThread t=new TimeThread();
	public Thread th;
	public Resolve(int table[][]){
		
		isResolved=true;
		t1=System.currentTimeMillis();
		th=new Thread(t);
		th.start();
		ResolveSudoku(table,1);
		th.stop();
	}
	
	public void ResolveSudoku(int table[][],int n){
		int b[][]=new int[9][9];
		int occ=nbOfnb(table);
		if(isResolved){
		if(n<=9){
			
			Mineur(table,n);
			
			for(int i=0;i<9;i++)
				for(int j=0;j<9;j++)
					b[i][j]=this.b[i][j];
			
			
			ResolveSudoku(table,n+1);
		
			for(int i=0;i<9;i++)
				for(int j=0;j<9;j++)
				{
					if(table[i][j]!=b[i][j] && table[i][j]==0 )
						table[i][j]=b[i][j];
					
					else if(table[i][j]!=b[i][j] && table[i][j]!=0 && b[i][j]!=0 )
						table[i][j]=-1;
					
				}
			if(n==1){
				for(int i=0;i<9;i++)
					for(int j=0;j<9;j++)
						if(table[i][j]==-1)
							table[i][j]=0;
			
				
				
		}
		}
			
		if(n==1 && !isFull(table) ){
			
			
			if(occ<nbOfnb(table)){
			
				ResolveSudoku(table,1);
				
						
			
			}else if(occ==nbOfnb(table))
			{
				//t2=System.currentTimeMillis();
				
				int c[]=new int [9];
				int x,y;
				String number,nb1;
			
				
			number=Possibility(table,c);
				
		
				
				
				nb1=String.valueOf(number.charAt(0));
				x=Integer.parseInt(nb1);
				
				nb1="";
				
				nb1=String.valueOf(number.charAt(2));
				y=Integer.parseInt(nb1);
				
				BruteForce(table,c,x,y);
				
					
			}
			
		}
	}
	}
	
	public void BruteForce(int table[][],int c[],int x,int y){
		int b[][]=new int [9][9],k=0;
		
		if(isResolved){
			
		
		while(c[k]!=0 && k<9){
		
			if(!isFull(b)){
			for(int i=0;i<9;i++)
				for(int j=0;j<9;j++)
					b[i][j]=table[i][j];
			
			b[x][y]=c[k++];
			
		
			ResolveSudoku(b,1);
			
		
			}
			else
				break;
			

			
		}
		if(isFull(b) && isCorrect(b))
		for(int i=0;i<9;i++)
			for(int j=0;j<9;j++)
				table[i][j]=b[i][j];

		
		}
	}
	
	public String Possibility(int table[][],int p[]){
		
		int c[][]=new int [9][9],k=0,i=0;
		String number;
		int x=0,y=0;
		b=new int[9][9];
		if(isResolved){
		for(x=0;x<9;x++)
		{
			for(y=0;y<9;y++)
				if(table[x][y]==0)
					{k=1;
					break;
					}
		if(k==1)
			break;
		}		
		
		for(k=1;k<10 ;k++)
		{
			for(int j=0;j<9;j++)
				for(int l=0;l<9;l++)
					c[j][l]=0;
			
			Mineur(table,k);
			for(int j=0;j<9;j++)
				for(int l=0;l<9;l++)
					c[j][l]=b[j][l];
		
			if(c[x][y]!=0)
				p[i++]=c[x][y];
		}
		}
		number=x+","+y;
		return number;
	
	}
	public boolean isFull(int table[][]){
		for(int i=0;i<9;i++)
			for(int j=0;j<9;j++)
				if(table[i][j]==0)
					return false;
		
		return true;
	}
	
	public int nbOfnb(int table[][]){
		int occ=0;
		for(int i=0;i<9;i++)
			for(int j=0;j<9;j++)
				if(table[i][j]!=0)
					occ++;
		return occ;
	}
	public void Mineur(int table[][] ,int nb){

		b=new int[9][9];
		for(int i=0;i<9;i++)
			for(int j=0;j<9;j++)
				b[i][j]=table[i][j];
		
		
		for(int i=0;i<9;i++)
			for(int j=0;j<9;j++)
				if(iCan(table,i, j, nb) && table[i][j]==0)
					b[i][j]=nb;
		
		
	}
	
public boolean isCorrect(int table[][]){
		
		for(int i=0;i<9;i++)
			for(int j=0;j<9;j++)
				if(!iCan(table,i,j,table[i][j]))
					return false;
				
				return true;
			
	}

public  boolean iCan(int table[][],int x,int y,int nb){
	
	
	for(int i=0;i<9;i++)
		if(i!=x)
			if(table[i][y]==nb)
				return false;
	
	for(int j=0;j<9;j++)
		if(j!=y)
			if(table[x][j]==nb)
				return false;
	
	for(int i=0;i<3;i++)
		for(int j=0;j<3;j++)
				if(table[3*(x/3)+(x+i)%3][3*(y/3)+(j+y)%3]==nb && 3*(x/3)+(x+i)%3 !=x && 3*(y/3)+(j+y)%3!=y)
					return false;
				
	return true;
}
class TimeThread implements Runnable{
	
	public synchronized void run(){
		
		t2=System.currentTimeMillis();
		
		while(t2-t1<4000)
				t2=System.currentTimeMillis();
			
			 isResolved=false;
			
		
		
	}
}
}

