# User Guide

## Features 

### Add a todo
Adds a task without deadline.

### Add a deadline
Adds a task with deadline.

### Add an event
Adds an event.

### Delete a task
Deletes a task.

### Complete a task
Mark a task as done.

### List every tasks in your task list
Lists out all your tasks.

### Tag your tasks
Add tags to task.

### Delete tags from tasks
Delete tags from task.

### Filter tasks based on tag
Filters tasks based on a specific tag.

### Filter tasks based on keyword
Filters tasks based on a specific keyword.

### List all tags
Lists out all the tags.

### Exit Duke
Exits Duke

## Usage

### `todo (description)`

Adds a todo to your task list.

Example of usage: 

`todo borrow book`

Expected outcome:

`Got it. I've added this task:`<br/>
`[T][✘] borrow book`<br/>
`Now you have 1 task(s) in the list.`
             

### `deadline (description) /by (dd/MM/yyyy HHmm)`

Adds a deadline to your task list.

Example of usage: 

`deadline lab /by 01/10/2019 2359`

Expected outcome:

`Got it. I've added this task:`<br/>
`[D][✘] lab (by: Tue Oct 01 23:59:00 SGT 2019)`<br/>
`Now you have 2 task(s) in the list.`

### `deadline (description) /by (dd/MM/yyyy HHmm) /tag (tag)`

Adds a deadline to your task list.

Example of usage: 

`deadline lab /by 01/10/2019 2359 /tag school cs`

Expected outcome:

`Got it. I've added this task:`<br/>
`[D][✘] lab (by: Tue Oct 01 23:59:00 SGT 2019) [school, cs]`<br/>
`Now you have 2 task(s) in the list.`

### `event (description) /at (dd/MM/yyyy HHmm)`

Adds an event to your task list.

Example of usage: 

`event dinner /at 01/10/2019 2359`

Expected outcome:

`Got it. I've added this task:`<br/>
`[E][✘] dinner (at: Tue Oct 01 23:59:00 SGT 2019)`<br/>
`Now you have 2 task(s) in the list.`

### `event (description) /at (dd/MM/yyyy HHmm) /tag (tag)`

Adds a deadline to your task list.

Example of usage: 

`event dinner /by 01/10/2019 2359 /tag home food`

Expected outcome:

`Got it. I've added this task:`<br/>
`[E][✘] dinner (at: Tue Oct 01 23:59:00 SGT 2019) [home, food]`<br/>
`Now you have 2 task(s) in the list.`

### `delete (task number)`

Deletes a task from your list.

Example of usage: 

`delete 2`

Expected outcome:

`Noted. I've removed this task:`<br/>
`[D][✘] lab (by: Tue Oct 01 23:59:00 SGT 2019) [school, cs]`<br/>
`"Now you have 1 task(s) in the list`

### `done (task number)`

Completes a task in your list.

Example of usage: 

`done 2`

Expected outcome:

`Nice! I've marked this task as done:`<br/>
`[T][✓] borrow book`

### `list`

Lists out all the tasks in your list.

Example of usage: 

`list`

Expected outcome:

`Here are the tasks in your list:`<br/>
`1. [T][✘] borrow book`<br/>
`2. [E][✘] dinner (at: Tue Oct 01 23:59:00 SGT 2019) [home, food]`



### `addtag (task number) (tag name)`

Adds a tag to the specified task.

Example of usage: 

`addtag 1 school`

Expected outcome:

`Tag has been added`<br/>
`[T][✘] borrow book [leisure, school]`

### `deltag (task number) (tag name)`

Deletes a tag from a specified task.

Example of usage: 

`deltag 1 school`

Expected outcome:

`Tag has been deleted`<br/>
`[T][✘] borrow book [leisure]`

### `findtag (tag name)`

Filters tasks based on specified tag.

Example of usage: 

`findtag school`

Expected outcome:

`Here are the tasks under school:`<br/>
`1. [T][✘] borrow book`<br/>
`2. [T][✘] assignment`


### `find (keyword)`

Filters tasks based on specified keyword.

Example of usage: 

`find lab`

Expected outcome:

`Here are the matching tasks in your list:`<br/>
    `1. [T][✘] lab 1`<br/>
    `2. [T][✘] lab 2`

### `listtag`

Output a list of all tags.

Example of usage: 

`listtag`

Expected outcome:

`Here are all the tags:`<br/>
    `school`<br/>
    `home`

### `bye`

Exits from Duke.

Example of usage: 

`bye`

Expected outcome:

`Bye. Hope to see you again soon!`





