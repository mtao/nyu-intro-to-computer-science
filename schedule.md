---
title: Schedule
layout: page
---




| Date | Class | Topics | Notes | Helpful resources | Quiz due | Exercise due |
| :--- | :---- | :----- | :---- | :---------------- | :------- | :----------- |
{% for class in site.data.schedule %} | {{ class.date }} | {{class.number}} | {{ class.topics }} | {{ class.notes }} | {{class.resources }} | {{ class.quiz }} | {{class.exercise }} | 
{% endfor %}

