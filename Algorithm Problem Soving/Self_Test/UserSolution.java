package Self_Test;

import java.util.List;

class UserSolution {
   
   static int MAX_SIZE = 50027;
   static int NULL = 0;
   static int NUM_FILED = 5;
   static int NODESIZE = 250001;
   static int MOD = 100007;
   
   static int idx;
   private class Node {
      private int id;
      private boolean exist;
      private Node nxt;   
      private Node() {}
      private Node(int id, boolean exist) {
         this.id = id;
         this.exist = exist;
      }
  
   }

   static Node[] nodes = new Node[NODESIZE];
   
   public Node newNode() {
      nodes[idx].exist = true;
      return nodes[idx++];
   }
   
   class mList{
      private Node head;
      private Node dummy;
      void init() {
         this.dummy= new Node();
         this.head = dummy;
         this.head.nxt = null;
      }
      void insert(int id) {
         Node node = newNode();
         node.id = id;
         
         node.nxt = head.nxt;
         head.nxt = node;
      }
   }
   
   static mList[][] hashTable = new mList[NUM_FILED][MOD];
   
   class DATA{
      String[] attr = new String[5];
   }
   static DATA[] Original = new DATA[MAX_SIZE];
   
   public boolean m_strcmp(String src1, String src2) {
      int leng = src1.length();
      for(int i=0; i<src1.length(); i++) {
         if(src1.charAt(i)!=src2.charAt(i)) return false;
      }
      if(leng<src2.length()) return false;
      return true;
   }
   
   int MY_HASH(String str) {
      int multi = 1, key = 0;
      for(int i=0; i<str.length(); i++) {
         key+=str.charAt(i)*multi;
         multi*=2;
      }
      return key%MOD;
   }
   
   static int id;
   
   void InitDB()
   {
      idx=0; id =0;
      for(int i=0; i<5; i++) {
         for(int j=0; j<MOD; j++) {
            hashTable[i][j].init();
         }
      }
      return;
   }

   void Add(String name, String number, String birthday, String email, String memo)
   {
      int nameHash = MY_HASH(name);
      int numberHash = MY_HASH(number);
      int birthHash = MY_HASH(birthday);
      int emailHash = MY_HASH(email);
      int memoHash = MY_HASH(memo);
      
      hashTable[Field.NAME][nameHash].insert(id);
      hashTable[Field.NUMBER][numberHash].insert(id);
      hashTable[Field.BIRTHDAY][birthHash].insert(id);
      hashTable[Field.EMAIL][emailHash].insert(id);
      hashTable[Field.MEMO][memoHash].insert(id);
      
      Original[id].attr[Field.NAME] = name;
      Original[id].attr[Field.NUMBER] = number;
      Original[id].attr[Field.BIRTHDAY] = birthday;
      Original[id].attr[Field.EMAIL] = email;
      Original[id].attr[Field.MEMO] = memo;
      id++;
      return;
   }

   int Delete(int field, String str)
   {
      int find_key = MY_HASH(str), cnt=0;
      Node tmp = hashTable[field][find_key].head.nxt;
      while(tmp.nxt!=null) {
         if(tmp.exist==false) {
            tmp = tmp.nxt;
            continue;
         }
         if(m_strcmp(Original[tmp.id].attr[field], str)) {
            tmp.exist = false;
            cnt++;
            for(int i=0; i<NUM_FILED; i++) {
               if(i==field) continue;
               int find_key2 = MY_HASH(Original[tmp.id].attr[i]);
               Node tmp2 = hashTable[i][find_key2].head.nxt;
               
               while(tmp2.nxt!=null) {
                  if(tmp2.exist == false) {
                     tmp2 = tmp2.nxt;
                     continue;
                  }
                  if(tmp2.id==tmp.id) {
                     tmp2.exist=false;
                     break;
                  }
                  tmp2 = tmp2.nxt;
               }
            }
            
         }
         tmp = tmp.nxt;
      }
      return cnt;
   }

   int Change(int field, String str, int changefield, String changestr)
   {
      int find_key = MY_HASH(str), cnt=0;
      Node tmp = hashTable[field][find_key].head.nxt;
      
      while(tmp.nxt!=null) {
         if(tmp.exist==false) {
            tmp=tmp.nxt;
            continue;
         }
         if(m_strcmp(Original[tmp.id].attr[field], str)) {
            int find_key2 = MY_HASH(Original[tmp.id].attr[changefield]);
            Node tmp2 = hashTable[changefield][find_key2].head.nxt;
            cnt++;
            while(tmp2.nxt!=null) {
               if(tmp2.exist==false) {
                  tmp2=tmp2.nxt;
                  continue;
               }
               if(tmp2.id ==tmp.id) {
                  tmp2.exist = false;
                  break;
               }
               tmp2 = tmp2.nxt;
            }
            find_key2 = MY_HASH(changestr);
            hashTable[changefield][find_key2].insert(tmp.id);
            Original[tmp.id].attr[changefield] = changestr;
         }
         tmp = tmp.nxt;
      }
      return cnt;
   }

   Solution.Result Search(int field, String str, int returnfield)
   {
      Solution.Result result = new Solution.Result();
      result.count = -1;
      int find_key = MY_HASH(str);
      Node tmp = hashTable[field][find_key].head.nxt;
      while(tmp.nxt!=null) {
         if (tmp.exist == false) {
            tmp = tmp.nxt;
            continue;
         }

         if (m_strcmp(Original[tmp.id].attr[field], str)) {
            result.count++;
            if (result.count == 1) {
               result.str=Original[tmp.id].attr[returnfield];
            }
         }
         tmp = tmp.nxt;
      }
      return result;
   }
}
