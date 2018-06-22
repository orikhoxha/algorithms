public class MostCommonWord {


    public static String mostCommonWord(String paragraph, String[] banned) {


        String caseIsensitiveCase = paragraph.toLowerCase().replaceAll("\\\\s*,\\\\s*$", "");
        caseIsensitiveCase = caseIsensitiveCase.replaceAll("[,.!?;']","");
        System.out.println(caseIsensitiveCase);


        List<String> bannedWords = Arrays.asList(banned);

        HashMap<String, Integer> commonWords = new HashMap<>();


        List<String> paragraphList = Arrays.asList(caseIsensitiveCase.split(" "));

        System.out.println(paragraphList);

        int len = paragraphList.size();


        for(int i = 0; i < len; ++i){
            String word = paragraphList.get(i);
            if(!bannedWords.contains(word)){
                if(commonWords.get(word) == null){
                    commonWords.put(word, 1);
                }else{
                    commonWords.put(word, commonWords.get(word) + 1);
                }
            }
        }

        Object maxEntry = Collections.max(commonWords.entrySet(), Map.Entry.comparingByValue()).getKey();

        return (String) maxEntry;

    }



    public static void main(String[] args){



        String paragraph = "Bob hit a ball, the. hit BALL flew far after it was hit.";

        String[] banned = new String[]{"hit"};


        String mostCommonWord = mostCommonWord(paragraph, banned);

        System.out.println(mostCommonWord);

    }
}