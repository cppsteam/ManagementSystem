/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function calculateScore() {
    var table = document.getElementById(table);
    var ordinaryScore, testScore;
    for (var i = 0; i < table.rows.length; i++) {
        ordinaryScore = table.rows[i].cells[2].innerText;
        testScore = table.rows[i].cells[3].innerText;
        table.rows[i].cells[4].innerText = ordinaryScore * 0.3 + testScore * 0.7;
    }
}


