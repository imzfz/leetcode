import java.util.*;

public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        Interval con, next;
        List<Interval> res = new ArrayList<>();

        if(intervals.size() <= 1){
            return intervals;
        }

        intervals.sort((o1, o2) -> {
            if (o1.start < o2.start)
                return -1;
            else if(o1.start == o2.start){
                return 0;
            }

            return 1;
        });

        con = intervals.get(0);

        for(int i = 1; i < intervals.size(); i++){
            next = intervals.get(i);

            if(next.start >= con.start && next.start <= con.end){
                if(next.end >= con.end){
                    con = new Interval(con.start, next.end);
                }
            }
            else if(next.start > con.end){
                res.add(con);
                con = intervals.get(i);
            }
            else {
                if(next.end >= con.end){
                    con = next;
                }
                else if(next.end < con.start){
                    res.add(con);
                    con = intervals.get(i);
                }
                else {
                    con = new Interval(next.start, con.end);
                }
            }
        }
        res.add(con);

        return res;
    }
}

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}