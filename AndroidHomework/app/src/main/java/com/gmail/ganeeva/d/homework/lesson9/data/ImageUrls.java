package com.gmail.ganeeva.d.homework.lesson9.data;

/**
 * Created by Diana on 17.08.2017 at 16:41.
 */

public class ImageUrls {
    private static String[] imageUrls = {
        "http://cdn.fishki.net/upload/post/201409/06/1301804/i2dpv50ftpg.jpg",
        "https://pp.userapi.com/c7005/v7005611/466cb/kxp7QIBqVAw.jpg",
        "https://pp.userapi.com/c840122/v840122966/16e29/k3UQoTR5njI.jpg",
        "https://pp.userapi.com/c543107/v543107540/1a2d9/Albu4oGl0Gk.jpg",
        "https://pp.userapi.com/c623329/v623329294/251ce/lnAf3M3jmmc.jpg",
        "https://pp.userapi.com/c625424/v625424295/2ce27/_lxtuFwyjUM.jpg",
        "https://pp.userapi.com/c619631/v619631313/1ced9/q9acoGbrcL0.jpg",
        "https://pp.userapi.com/c623123/v623123927/1a233/e5eLA8ElS9o.jpg",
        "https://pp.userapi.com/c623123/v623123927/19a4e/LnRbawDkDrQ.jpg",
        "https://pp.userapi.com/c622218/v622218529/f525/LshfgGvRroc.jpg",
        "https://cs7065.userapi.com/c540107/v540107697/10c8c/brqeN439un4.jpg",
        "https://pp.userapi.com/c7008/v7008920/31ffb/ou43lGm5aM4.jpg",
        "https://pp.userapi.com/c623123/v623123877/1412e/_lXcox0XuBU.jpg",
        "https://pp.userapi.com/c622828/v622828927/ec67/tKrQzDNWImk.jpg",
        "https://cs7065.userapi.com/c540102/v540102571/2fafb/wLSZI_By2lc.jpg",
        "https://pp.userapi.com/c618131/v618131931/1c33b/9iAh8OXFCiM.jpg",
        "https://pp.userapi.com/c618631/v618631394/154a2/msjgldX8hpY.jpg",
        "https://pp.userapi.com/c619430/v619430929/1845c/AwvZam4Ruho.jpg",
        "https://pp.userapi.com/c416523/v416523165/19b1/rb7buJ-vJCc.jpg",
        "https://cs7065.userapi.com/c540101/v540101920/11adf/cLw2LqnPLxs.jpg",
        "https://pp.userapi.com/c409826/v409826763/3411/tU7I4EPfvu4.jpg"
    };

    public static String getImageUrl(int position) {
        return imageUrls[position];
    }

    public static int getImagesCount() {
        return imageUrls.length;
    }
}
