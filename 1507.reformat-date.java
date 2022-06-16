/*
 * @lc app=leetcode id=1507 lang=java
 *
 * [1507] Reformat Date
 */

// @lc code=start
class Solution {
    public String reformatDate(String date) {
        String[] splits = date.split(" ");
        String year = splits[2];
        String month = splits[1];
        String day = splits[0];
        day = day.substring(0, day.length() - 2);
        if (day.length() == 1) {
            day = "0" + day;
        }
        month = transMonth(month);

        return String.format("%s-%s-%s", year, month, day);
    }

    public String transMonth(String month) {
        switch (month) {
            case "Jan":
                return "01";
            case "Feb":
                return "02";
            case "Mar":
                return "03";
            case "Apr":
                return "04";
            case "May":
                return "05";
            case "Jun":
                return "06";
            case "Jul":
                return "07";
            case "Aug":
                return "08";
            case "Sep":
                return "09";
            case "Oct":
                return "10";
            case "Nov":
                return "11";
            case "Dec":
                return "12";
            default:
                return "";
        }
    }
}
// @lc code=end
