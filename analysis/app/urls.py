from django.urls import path

from . import views

urlpatterns = [
    path("ui",views.uiInfo, name="ui"),
    path('', views.index, name='index'),
]