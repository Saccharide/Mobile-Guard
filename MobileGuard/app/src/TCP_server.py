import socket

def Main():
	host = "100.86.22.39"
	port = 8080

	s = socket.socket()
	s.bind((host,port))

	s.listen(1)
	connection, addr = s.accept()
	print "Connection from : " + str(addr)
	while True:
		data = connection.recv(1024)
		if not data:
			break
		data = str(data)
		print "From connected user: " + data
		
	connection.close()

if __name__ == '__main__':
	Main()
