package main.java.part2;

public class Roles {
    public static void main(String[] args) {
        String [] roles= {
                "Городничий","Аммос Федорович",
                "Артемий Филиппович",
                "Лука Лукич"};
        String [] textLines={
                "Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.",
                "Аммос Федорович: Как ревизор?",
                "Артемий Филиппович: Как ревизор?",
                "Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.",
                "Аммос Федорович: Вот те на!",
                "Артемий Филиппович: Вот не было заботы, так подай!",
                "Лука Лукич: Господи боже! еще и с секретным предписаньем!"};
        System.out.println(printTextPerRole(roles,textLines));
    }

    private static String printTextPerRole(String[] roles, String[] textLines) {
        StringBuilder result = new StringBuilder();
        for (String role:roles) {
            int i =0;
            result.append(role).append(":\n");
            final String regex = "^" + role + ":";
            final java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(regex);
            for (String line:textLines) {
                i++;
                final java.util.regex.Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    result.append(i).append(")").append(line.replaceAll(regex, "")).append("\n");
                }
            }
            result.append("\n");
        }
        return result.toString();
    }

}
