---
layout: page
title: Table
permalink: /table/
---

<style type="text/css">

    .table {
        border-spacing: 0;
    }

    .table thead th {
        padding: 5px;
        font-weight: 500;
    }

    .table tbody tr {
        background-color: #eee;
    }

    .table tbody tr:hover {
        background-color: #e4e4e4;
    } 

    .table tbody td {
        padding: 7px 10px;
        border-bottom: 1px solid #ffffff;
        font-size: 14px;
    }

</style>

<h3>FIFA League Devs - Season 2016/17</h3>

<h4>1st Division</h4> 

<table width="100%" class="table">

    <thead>
        <tr>
            <th align="left">Team</th>
            <th align="center">Played</th>
            <th align="center">Won</th>
            <th align="center">Drawn</th>
            <th align="center">Lost</th>
            <th align="center">GF</th>
            <th align="center">GA</th>
            <th align="center">GD</th>
            <th align="center">Points</th>
        </tr>
    </thead>

    <tbody>
        {% for team in site.data.table %}
            <tr>
                <td align="left">{{team.team}}</td>
                <td align="center">{{team.played}}</td>
                <td align="center">{{team.won}}</td>
                <td align="center">{{team.drawn}}</td>
                <td align="center">{{team.lost}}</td>
                <td align="center">{{team.goalFor}}</td>
                <td align="center">{{team.goalAgainst}}</td>
                <td align="center">{{team.goalDifference}}</td>
                <td align="center"><strong>{{team.points}}</strong></td>
            </tr>
        {% endfor %}
    </tbody>

</table>