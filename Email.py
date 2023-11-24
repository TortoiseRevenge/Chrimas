import smtplib
from email.mime.text import MIMEText

sender = ""
password = ""


def send_email(subject, body, sender, recipient, password):
    msg = MIMEText(body)
    msg['Subject'] = subject
    msg['From'] = sender
    msg['To'] = recipient
    with smtplib.SMTP_SSL('smtp.gmail.com', 465) as smtp_server:
       smtp_server.login(sender, password)
       smtp_server.sendmail(sender, recipient, msg.as_string())
    print("Message sent!")

def sendEmails():
    with open('saveList.txt', 'r') as file:
        lines = file.readlines()
        for i, line in enumerate(lines):
            name = line.split(',')[0].strip()
            email= line.split(',')[1].strip()
            next_name = lines[(i + 1) % len(lines)].split(',')[0].strip()
            subject = f"Paulsen Christmas Exchange"
            body = f"Hi {name},\n\nYou are gitfting to {next_name} for the Paulsen Christmas Exchange!\n\nMerry Christmas"
            send_email(subject, body, sender, email, password)
            print(email)
            print(body)
            print("-----------")
            
sendEmails()
