---
layout: page
title: Results
permalink: /results/
---

<style type="text/css">

    .table {
        border-spacing: 0;
    }

    .table thead th {
        padding: 5px;
        font-weight: 500;
        background-color: #000000;
        color: #ffffff;
    }

    .table tbody tr {
        background-color: #eee;
    }

    .table tbody tr:hover {
        background-color: #e4e4e4;
    } 

    .table tbody td {
        padding: 7px 5px;
        border-bottom: 1px solid #ffffff;
        font-size: 14px;
    }

</style>


<h3>FIFA League Devs - Season 2016/17</h3>

<h4>1st Division</h4> 

{% for round in site.data.results %}

<table width="100%" class="table">

    <thead>
        <tr>
            <th align="center" colspan="3">Round {{forloop.index}}</th>
        </tr>
    </thead>

    <tbody>
        {% capture Nround %}round-{{forloop.index}}{% endcapture %}
        {% for match in site.data.results[Nround] %}
            <tr>
                <td align="center">{{match.home_team}}</td>
                <td align="center">{{match.away_team}}</td>
                <td align="center"><strong>{{match.home_score}}-{{match.away_score}}</strong></td>
            </tr>
        {% endfor %}
    </tbody>

</table>
    
{% endfor %}