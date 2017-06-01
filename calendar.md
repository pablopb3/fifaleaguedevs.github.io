---
layout: page
title: Calendar
permalink: /calendar/
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

{% for round in site.data.calendar.Calendar %}
<table width="100%" class="table">

<thead>
    <tr>
        <th align="center" colspan="3">Round {{round.Jornada}}</th>
    </tr>
</thead>

<tbody>
    {% for match in round.Partidos %}
        <tr>
            <td align="center">{{match.equipoLocal}} (<span style="color:#1756a9;">{{match.githubLocal}}</span>)</td>
            <td align="center">{{match.equipoVisitante}} (<span style="color:#1756a9;">{{match.githubVisitante}}</span>)</td>
            <td align="center"><em>Match ID: {{match.id}}</em></td>
        </tr>
    {% endfor %}
</tbody>

</table>
{% endfor %}