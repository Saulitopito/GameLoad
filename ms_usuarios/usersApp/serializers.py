from django.db.models import fields
from rest_framework import serializers
from .models import appUser
from django.contrib.auth.hashers import make_password

class appUserSerializer(serializers.ModelSerializer):
    class Meta:
        model = appUser
        fields = ['id', 'username', 'name', 'password', 'email', 'address']

    def validate_password(self, value):
        return make_password(value)