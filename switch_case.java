
  Group = (RadioGroup) findViewById(R.id.RadioG);
  Group.setOnCheckedChangeListener(new RadioGroup.setOnCheckedChangeListener())
  {
    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId)
    {
      switch( checkedId)
      {
        case R.id.radioButtonSong:
            Toast.makeText(MainActivity.this, "Da chon song", Toast.LENGTH.SHORT);
            break;
        case R.id.radioButtonTrue:
            Toast.makeText(MainActivity.this, "Da chon true", Toast.LENGTH.SHORT);
            break;
        case R.id.radioButtonChieu:
            Toast.makeText(MainActivity.this, "Da chon chieu", Toast.LENGTH.SHORT);
            break;
      }
    }
  }