class Solution {
    public boolean solution(String[] phone_book) {
        for(int i = 0; i < phone_book.length; i++){
            for(int j = i + 1; j < phone_book.length; j++){
                
                if(phone_book[i].length() < phone_book[j].length()) {
                    if(phone_book[i].indexOf(phone_book[j]) != -1)
                        return false;
                } else {
                    if(phone_book[j].indexOf(phone_book[i]) != -1)
                        return false;
                }
            }
        }
        return true;
    }
}
