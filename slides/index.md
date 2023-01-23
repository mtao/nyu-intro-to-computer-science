---
title: Schedule
layout: page
---

Here's a listing of slides, check out the [schedule](/schedule) for more.

| Date | Class | Topics | Notes |
| :--- | :---- | :----- | :---- |
{% for class in site.data.schedule %} | {{ class.date }} | {{class.number}} | {{ class.topics }} | {{ class.notes }}  | 
{% endfor %}

