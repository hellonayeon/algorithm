import java.util.HashSet;

class Coordinate implements Cloneable{
    int x;
    int y;
    
    public Coordinate() {
        x = 0; y = 0;
    }
    
    public void setX(int value) {
        x += value;
    }
    
    public void setY(int value) {
        y += value;
    }
    
    @Override
    public Coordinate clone(){
        Object obj = null;
        try{
            obj = super.clone();
        } catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        return (Coordinate) obj;
    }
}

class VisitLength {
    public int solution(String dirs) {
        HashSet<String> path = new HashSet<>();
        
        Coordinate cur = new Coordinate();
        Coordinate next = new Coordinate();
        
        for(int i = 0; i < dirs.length(); i++) {
            move(dirs.charAt(i), next);
            // 좌표평면의 범위를 벗어나는 경우
            if(next.x < -5 || next.x > 5 || next.y < -5 || next.y > 5) {
                next = cur.clone(); 
                continue;
            }
            
            path.add("" + cur.x + next.x + cur.y + next.y);
            path.add("" + next.x + cur.x + next.y + cur.y);
            cur = next.clone();
        }
        
        return path.size()/2;
    }
    
    public void move(char direction, Coordinate cor) {
        switch(direction) {
            case 'U':
                cor.setY(1);
                break;
            case 'D':
                cor.setY(-1);
                break;
            case 'L':
                cor.setX(-1);
                break;
            case 'R':
                cor.setX(1);
                break;
        }
    }
}