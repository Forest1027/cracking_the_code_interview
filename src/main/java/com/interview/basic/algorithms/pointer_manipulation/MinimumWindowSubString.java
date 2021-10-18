package com.interview.basic.algorithms.pointer_manipulation;

import java.util.HashMap;
import java.util.Map;

/**
 * 76. Minimum Window Substring
 * https://leetcode.com/problems/minimum-window-substring/
 */
public class MinimumWindowSubString {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }
        // create map to contain all required characters
        Map<Character, Integer> required = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            int count = required.getOrDefault(t.charAt(i), 0);
            required.put(t.charAt(i), count + 1);
        }
        int requiredSize = required.size();
        // create pointers
        int l = 0;
        int r = 0;

        // keep track of length and pointers
        int[] tracker = {-1, l, r};
        // keep track of current valid characters
        int currentSize = 0;
        Map<Character, Integer> current = new HashMap<>();
        while (r < s.length()) {
            char c = s.charAt(r);
            Integer count = current.getOrDefault(c, 0);
            current.put(c, count + 1);
            if (required.containsKey(c) && current.get(c).equals(required.get(c))) {
                currentSize++;
            }
            while (l <= r && (requiredSize == currentSize)) {
                // move left pointer
                if (tracker[0] == -1 || r - l + 1 < tracker[0]) {
                    tracker[0] = r - l + 1;
                    tracker[1] = l;
                    tracker[2] = r;
                }
                // remove the element on l position from map
                Integer leftCount = current.get(s.charAt(l));
                current.put(s.charAt(l), leftCount - 1);
                if (required.containsKey(s.charAt(l)) && current.get(s.charAt(l)) < required.get(s.charAt(l))) {
                    currentSize--;
                }
                l++;
            }
            r++;
        }
        return tracker[0] == -1 ? "" : s.substring(tracker[1], tracker[2] + 1);
    }

    public static void main(String[] args) {
        MinimumWindowSubString sol = new MinimumWindowSubString();
//        System.out.println(sol.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(sol.minWindow("senwelsrfsibvyycqyfaxwxclrnzlacggpckawcfqkgnkgsaexaetzgeqtdcvfibummwkqcackpnrhnxfqbyrjfidimaqwcmiojselugvjvorjmybpyszdaeooegkgsuwbocoilmugcnpqlsgjlhpnlfcrloadjwhxzxiklesoriecamnntebejfwutyacujcvgmhuqakhiolkbaawfbbqgzlzxnetwipewwymwkvgzitcktyrwbiecvdbijvgtkkpildhvapwkiaxdbozcydhtjidudlqpyhallhgnwfahhxminmnmruhcenzkypzwwbhjiqzhxzoeyaplocxiyhmeulosaorzrykaqjjnkzuibjuqntancmrwygrawkbnkmnbvyqixkqzvmpkirxkdpjdvagtmhgwvwxtuqbscrrygikoziyexjkulspxzvuxrtqojrgmkzmqjygkgfqfqabcsqzumtrfnjvyabmmcaflzlvfsmnjooljhkdvewatfwrhzetegypfmnnebanpqyaxjdspbvkgtbpuhlyqjqvxdicgkpxbqyabbvsdscllfbfpmgfxwaxblzhxqeaicbjgydlqfyblbicnohnkjklulusdzumdvvjvzwlgvotwxvmncbymnliygcbhxnkulwqmsdsnsompjycmzcaoqkmynpfmfrgsnyegcyvumhlyhpkismwiwkglanxfegxsedaidxcshnqofaxxovhkgpwgcvngbmagraouytmficvneumuqthwifekattchtkywauwtjbenyrsteolzvjkapwbipfrlrrhrldnwgrkekezqskqqtcqiytsoajbrcijonymvpwbbcbsvnkljmdtkxmazxbralcqaacvrbzsdamapwnyktuxsgzrfdifokxrmcmdflwknilfhaftvzqnhsfnvpujcuaowpsbcqlsayxhbcdwctkjlryiitskpuzlltoojbgjadtdhwzlrlxfevnnqhzfeasptgdeilqkqlnyhojacghicvvuexcixuyrbdxjpnvfyifhypkavrlzoiwvfyddsdwvhtgyjbfjlltkcdmzwxbngxilxnqprolairatthcesxqwadwzcxmiwwwtjoicdvcnpegkmkqgihdkmzjoyxzuvxnflxhqtmdkqlucwkjgroqfnculbvhxsueftlwozbyqnsulffrwtjeilyvptcmnyqssdqgdsfvhzrsezlduuhdihyxcdjpbbjteaajuhebiyvnxgsrazuigvhiyqzbtivykxjegohooeblmtcnuzxcwhkuzlxtusterclxsumgbprnlwchvckrjwniikbcfwiwzvwtsiatztimplumnefyaugihkmmixkjugdmqdhqyseodycsckqfeypnkebvbmexuhklmtdlljbqidkmncrudjhnnjiqxnntwzgjtlugvvzdajpqmjmpstehepxdekxakdjfpfnmampdwgtkphbjafqhwpmaalbkrmriseuurjzprubjbcuejnngczgcljoeyhmqmgmfrmwiixtkbookbbsdczinkwriefaslpxedvnlsivtwjfxmydpzleljyupduhrlgvobkavtvqrhwrvwukxfriqpcguzpnkyjbbvbxqynihlzdjtpgagpqxtyuuqhhoqipojoehempplubgjhgqyzpuzjorrvhjfxxoncyrqpjcjkkuttksscotlclcasofrlwhpwyglhkwtuqnndhhfvbqzovbijhaufjmbhsmrcikwazkdgriduzdiwerfntbscntlfhejrrgsqsvzjgcgfhodohidcjygztugbyqspwmgqihbolhvvyajhioktmssgmzjlpdcnqkdareqdmnymnjtvzfqmyjukkdxbgaqyktyezohnbhzqsvlracfynzlzeiankslxlmbmckaerbujwicxmixbjiaorcdduqahcdvfnvlgzhrxruudcsgncibvmgzixbpzhlewirdjzwhqqdwuxciallvzswipyzqfmvbxmggndpevtcsqecsrnorhkbwkaprnkvkybsogisebuwtaymuncnxoovzokqdulnvpgjxodbrzxmbxavnciktwfsnqkqmygjpmsmcxovynjankvamekhcrzphmiumofbcypgxfbwtkygwtilzuselutvgdrurwvtwmzuscslpqtlldwlxprkjkfrqwlhtidpuelmhfzyvsjjviuuznfkzkbpjoxewavqghdnmcnkxztuhppicwsbitrrjqvfsrxyacoohbyeatajkprmnjqwejnnblutcsteuhsblthnmixxzqlnadjgoywpjqknkerhnmkafsotclsddgqdjbmaakplcabnguuvggwnykhcxzgafwgraurceingkqtslporwkfwwozvnfxvdfofzhhdpxmcnhuyzisxuztsnuncblzhqnmsuwxmtjoitihstbpnakgpfvrigrpzectbyqptcdbvnkpgleunoccvxuegntfrxauxsjquourcegksmefbikygeemratkxthxlspihjzlqiviucpxkzwqfaeyaxlassxgkoqtypeoxcyue",
                "ynmvuydbyrqkgzfakyrzmbcdtohrnyvmljhhhnkhgarmbwomwilljqocextrvqficnslcctkdkxejnqhvesfuhjygfrcxxmzmelohgamsxqbnjjipbpjkbjrgavdxhfjmsztyafqzxuoifzxgoitprkxshdroidacevcgcsicowktvkcmsvbkhbeoeveoahqfesnhmvldsxwphabaxfmegsukpzaqiqxmkktyigbaeaplatnyybeetbqjcqbkgywsksqsyuueumswfhwdjbheczpgpqqxqmpbghvhdqlzcdwjlsmwvvazuqfjivgbkxcsgzzkrljtqhebcqxxlaxhsesaaybmxfeeheqyrbuhlylnpkkckjmcoefqdgccogivmytdcnnnoyadimhtytxoycedlihboqwdqrgshthvthacwjxuduidzoikwpnmflpwcwqlryinhkpdumzzihehvmttbggjrvfwtxjnvsadepiydizlrdvppoitvocokjkfgwscoshsjptmzuaryvgplokgdmxpvjuefpivjpqtgjhgdhxdefvqtfyysvpphmtmbbiksyfzjnhowesdlntestfmrucygvkjzuwrubqdozunfmqqblvvecivwktfhgoicmaxosceswrxkjqlulhznrwldsskyjvcvvbjneohchhntxankjozalkdddqdolfjihtxnjfrsogllhzvspwtagyflqizdqllzejmpqfhemvrvwonlkimsjrgzchdssqrybfnrkxxwsorochzopnhyhnajudbnvunxzbolyoisebijijxazeygtypqdsfbmsyltowtcgnhkxsshpugwvmptdhzvmahhauaoqwtzlajjsdsjyyftmxorepmtpvaprcgjaziobrxvxpexpmqdjgupwiknfkfwplfrmqfnjcigtmdkavnjcjbytlnayswpfegrumedqommdpwdlkpnvqnrdarbvqsauzuqnytdpfrsxovkakxvcmm"));
    }
}
