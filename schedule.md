---
title: Schedule
layout: page
---


Lectures are held on Monday and Wednesday from 3:30-4:45 at
[GCASL, Room 275](https://library.nyu.edu/services/campus-media/classrooms/gcasl-275/), but check the #announcements channel on  [our Slack](/syllabus#messaging) for updates.




| Date | Class | Topics | Notes | Helpful resources | Quiz due | Exercise due |
| :--- | :---- | :----- | :---- | :---------------- | :------- | :----------- |
{% for class in site.data.schedule %} | {{ class.date }} | {{class.number}} | {{ class.topics }} | {{ class.notes }} | {{class.resources }} | {{ class.quiz }} | {{class.exercise }} | 
{% endfor %}

