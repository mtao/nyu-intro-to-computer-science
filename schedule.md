---
title: Schedule
layout: page
---


Lectures are held on Monday and Wednesday from 3:30-4:45 at

251 Mercer St (Warren Weaver) Room 101

, but check announcmenets on [Brightspace]({{ site.brightspace_url }}) as well.




| Date | Class | Topics | Notes | Helpful resources | Quiz due |
| :--- | :---- | :----- | :---- | :---------------- | :------- |
{% for class in site.data.schedule %} | {{ class.date }} | {{class.number}} | {{ class.topics }} | {{ class.notes }} | {{class.resources }} | {{ class.quiz }} | 
{% endfor %}

