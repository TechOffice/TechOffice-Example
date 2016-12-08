'''
Python Class Example
'''
class Student:
	# Constructor of Student
	def __init__(self, name):
		self.name = name
	
	# Student study() method
	def study(self, thing):
		print(self.name + " is studying " + thing)
	
# Main Program
student = Student('Test Student')
print(student.name)
student.study("something")